package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root);
    }

    private String serializeHelper(TreeNode node) {
        if(node == null) {
            return " null";
        }

        String str = " " + node.val;
        str += serializeHelper(node.left);
        str += serializeHelper(node.right);

        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String st = data.substring(1);
        String[] arr = st.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list) {
        if(list.size() == 0) {
            return null;
        }

        String val = list.get(0);
        if(val.equalsIgnoreCase("null")) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        list.remove(0);
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;
    }
}
