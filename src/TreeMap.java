// TODO: Remove each 'todo' comment once I implement each part!

// TODO: class comment header

public class TreeMap<K extends Comparable<K>, V> extends AbstractTreeMap<K, V> {
	private TreeNode root;
	private int height;
	
	public TreeMap() {
		Map<K, V> tmap;
		height = 0;
	}
		
	// TODO: comment header
	public String toString() {
		return inorder(root);
	}
	
	 protected String inorder(TreeNode node) {
			if (node==null)
			    return "";
			return inorder(node.left) + " " + node.key + " " + inorder(node.right);
	 }
//	
//	private String traverseString(TreeNode node){
//		String finalString = "{";
//		String kv = "";
//		String rightkv = "";
//		
//		if (node!= null) { 
//			 // recursive case: print left, center, right 
//			 traverseString(node.left); 
//			 kv = node.key+"="+node.value+" ";
//			 System.out.print(kv); 
//			 traverseString(root.right);
//			 System.out.print(kv); 
		
		
//		if (node == null) {
//			return "";
//		} else {
//			if (node.left != null) {
//				TreeNode left = node.left;
//				leftkv = leftkv + left.key+left.value;
//				traverseString(left);
//			}
//			
//			if (node.right != null) {
//				TreeNode right = node.right;
//				rightkv = rightkv + right.key+right.value;
//				traverseString(right);
//			}
			
//		}
//		return finalString = finalString + kv+"}";
//		}
	
	// Overriding the AbstractTreeMap put helper method
	protected TreeNode put(TreeNode node, K key, V value) {
		root = super.put(root, key, value);
	 // get root churning through .put
//		int heightLeft = super.computeHeight(node.left);
//		int heightRight = super.computeHeight(node.right);
//		System.out.println(heightLeft);
//		System.out.println(heightRight);
		
		return root;
	}
	
	// TODO: comment header
	protected TreeNode remove(TreeNode node, K key) {
		// TODO: implement this method
		return super.remove(node, key);
	}
}
