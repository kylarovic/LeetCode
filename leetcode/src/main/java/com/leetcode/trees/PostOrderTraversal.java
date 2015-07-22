package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 7/22/15.
 */
public class PostOrderTraversal {

    /*
    add nodes right first, then left, and mark it as visited.
     */
    public List<Integer> postOrderTraversal(TreeNode root) {

        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> k = new Stack<TreeNode>(); // to keep track of visited nodes
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;

       s.push(root);
        while(!s.isEmpty()) {
            TreeNode t = s.peek();
            if(!k.isEmpty() && (t == (k.peek()))) {
                list.add(s.pop().val);
                k.pop();
            }else {
                k.push(t);
                if(t.right != null) s.push(t.right);
                if(t.left != null) s.push(t.left);
            }
        }
        return list;
    }
}
