package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on 7/21/15.
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderWithNullMarker(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentLevel = new ArrayList<Integer>();
        if (root == null)
            return result;

        q.add(root);
        q.add(null); // add level marker
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp != null) {
                currentLevel.add(temp.val); //add temp to current level
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            } else {
                result.add(currentLevel); //add all current level to result
                currentLevel = new ArrayList<Integer>();
                if (!q.isEmpty()) q.add(null); //add marker 'null' if there are still elements left in q.
            }
        }
        return result;
    }


    //Cleaner way without using 'null' as marker for level

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while(true){
            if (level.isEmpty() || level.get(0) == null){
                break;
            }
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            List<Integer> currentLevel = new ArrayList<Integer>();

            for (TreeNode node : level){
                currentLevel.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            result.add(currentLevel);
            level = nextLevel;
        }
    return result;
    }
}
