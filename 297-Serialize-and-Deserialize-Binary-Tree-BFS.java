/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
       
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                str.append("null,");
                continue;
            }  
            str.append(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        
        return new String(str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null,")) return null;
        
        Queue<String> UnDeserializedVal = new LinkedList<String>();
        UnDeserializedVal.addAll(Arrays.asList(data.split(",")));
        Queue<TreeNode> DeserializingNode = new LinkedList<TreeNode>();
        
        TreeNode root = new TreeNode(Integer.parseInt(UnDeserializedVal.poll()));
        DeserializingNode.offer(root);
        while (!UnDeserializedVal.isEmpty()) {
           TreeNode node = DeserializingNode.poll();
           String childVal = UnDeserializedVal.poll();
           if (!childVal.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(childVal));
                DeserializingNode.offer(node.left);
           }
           childVal = UnDeserializedVal.poll();
           if (!childVal.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(childVal));
                DeserializingNode.offer(node.right);
           }
        }
        
        return root;    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
