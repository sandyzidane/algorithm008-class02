import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _297_二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);

        node.right.right = new TreeNode(6);

        String s = new _297_二叉树的序列化与反序列化().new Codec().serialize(node);
        System.out.println(s);
    }

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
    
}