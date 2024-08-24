package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

import java.util.Arrays;

public class CreateBTFromPreOrderInOrder {
    public TreeNode build(int[] preorder, int[] inorder) {
        if(preorder.length < 1) {
            return null;
        }

        int currentNodeValue = preorder[0];
        int index = 0;
        for(index = 0; index < inorder.length; index++) {
            if(inorder[index] == currentNodeValue) {
                break;
            }
        }

        TreeNode currentNode = new TreeNode(currentNodeValue);
        currentNode.left = build(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        currentNode.right = build(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return currentNode;
    }
}
