import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class 二叉树的序列化与反序列化 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serializeHelper(root, "");
        }

        public String serializeHelper(TreeNode root, String str) {
            if (root == null) {
                str += "null,";
            } else {
                str += String.valueOf(root.val) + ",";
                str = serializeHelper(root.left, str);
                str = serializeHelper(root.right, str);
            }
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] str = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(str));
            return deserializeHelper(list);
        }

        public TreeNode deserializeHelper(List<String> list) {
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = deserializeHelper(list);
            root.right = deserializeHelper(list);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}