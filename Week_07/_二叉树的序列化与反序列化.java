import java.util.*;

public class _二叉树的序列化与反序列化 {

    /**
     * 
     * 思路 对于空的节点，填充一个null值进去，把二叉树凑成一个满二叉树
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String res = doSerialize("", root);
            return res;
        }

        public String doSerialize(String res, TreeNode root) {
            if (root == null) {
                res += "null,";
                return res;
            }

            res += root.val + ",";
            res = doSerialize(res, root.left);
            res = doSerialize(res, root.right);
            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArr = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(dataArr));
            return doDeserialize(list);
        }

        private TreeNode doDeserialize(List<String> l) {
            if (l.get(0).equals("null")) {
                l.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
            l.remove(0);
            root.left = doDeserialize(l);
            root.right = doDeserialize(l);

            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

}