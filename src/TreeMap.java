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
		if (super.isEmpty()){
			return "{}";
		}
		System.out.print("{");
		String finalString = inorder(root);
		return finalString.substring(0, finalString.length()-2)+"}";
	}
	
	 protected String inorder(TreeNode node) {
			if (node==null)
			    return "";
			 return inorder(node.left) + node.key + "=" + node.value + ", " + inorder(node.right);
			 
	 }
	private int balanceFactor(TreeNode root){
		int balanceFactor = 0;
		if(root.right == null && root.left != null) {
			balanceFactor = 0-root.left.height;
		}else if(root.left == null && root.right != null){
			balanceFactor = root.right.height - 0;
		}else if (root.left == null && root.right == null){
			balanceFactor = 0;
		}else{
			balanceFactor = root.right.height - root.left.height;
		}
		return balanceFactor;
	}
	
	private int childBalanceFactorLeft(TreeNode root){
		int childBalanceFactor = 0;
		if(root.left.left == null && root.left.right !=null){
			childBalanceFactor = root.left.right.height-0;
		} else if (root.left.right == null && root.left.left != null){
			childBalanceFactor = 0-root.left.left.height;
		}else if (root.left.left == null && root.left.right == null){
			childBalanceFactor = 0;
		}else{
			childBalanceFactor = root.left.right.height - root.left.left.height;
		}
		return childBalanceFactor;
	}
	private int childBalanceFactorRight(TreeNode root){
		int childBalanceFactor = 0;
		if(root.right.left == null && root.right.right !=null){
			childBalanceFactor = root.right.right.height-0;
		} else if (root.right.right == null && root.right.left != null){
			childBalanceFactor = 0-root.right.left.height;
		}else if (root.right.left == null && root.right.right == null){
			childBalanceFactor = 0;
		}else{
			childBalanceFactor = root.right.right.height - root.right.left.height;
		}
		return childBalanceFactor;
	}
	
	protected TreeNode put(TreeNode node, K key, V value) {
		root = super.put(node, key, value);	
		//determine balanceFactor
		int balanceFactor = balanceFactor(root);
		//perform rotation if balanceFactor is >1 or <-1
		if (balanceFactor < -1){
			//figure out left side childBalanceFactor
			int childBalanceFactor = childBalanceFactorLeft(root);
			//perform rotation based on left side childBalanceFactor
			if(childBalanceFactor < 0){
				rightRotate(root);
			}else if (childBalanceFactor > 0){
				leftRotate(rightRotate(root));
			}
			
		}else if (balanceFactor > 1){
			//figure out right side childBalanceFactor
			int childBalanceFactor = childBalanceFactorRight(root);
			//perform rotation based on left side childBalanceFactor
			if(childBalanceFactor < 0){
				rightRotate(leftRotate(root));
			}else if (childBalanceFactor > 0){
				leftRotate(root);
			}
		}
		
		return root;
	}
	
	private TreeNode rightRotate(TreeNode oldParent) {
		// 1. detach left child's right subtree
		TreeNode orphan = oldParent.left.right;
		// 2. consider left child to be the new parent
		TreeNode newParent = oldParent.left;
		// 3. attach old parent onto right of new parent
		newParent.right = oldParent;
		// 4. attach new parent's old right subtree as
		// left subtree of old parent
		oldParent.left = orphan;
		oldParent.height = computeHeight(oldParent); // update nodes'
		newParent.height = computeHeight(newParent); // height values
		return newParent;
		}
	
	private TreeNode leftRotate(TreeNode oldParent) {
		// 1. detach right child's left subtree
		TreeNode orphan = oldParent.right.left;
		// 2. consider right child to be the new parent
		TreeNode newParent = oldParent.right;
		// 3. attach old parent onto left of new parent
		newParent.left = oldParent;
		// 4. attach new parent's old left subtree as
		// right subtree of old parent
		oldParent.right = orphan;
		oldParent.height = computeHeight(oldParent); // update nodes'
		newParent.height = computeHeight(newParent); // height values
		return newParent;
		}
	// TODO: comment header
	protected TreeNode remove(TreeNode node, K key) {
		super.remove(node, key);
		int balanceFactor = balanceFactor(root);
		//perform rotation if balanceFactor is >1 or <-1
				if (balanceFactor < -1){
					//figure out left side childBalanceFactor
					int childBalanceFactor = childBalanceFactorLeft(root);
					//perform rotation based on left side childBalanceFactor
					if(childBalanceFactor < 0 || childBalanceFactor == 0){
						rightRotate(root);
					}else if (childBalanceFactor > 0){
						leftRotate(rightRotate(root));
					}
					
				}else if (balanceFactor > 1){
					//figure out right side childBalanceFactor
					int childBalanceFactor = childBalanceFactorRight(root);
					//perform rotation based on left side childBalanceFactor
					if(childBalanceFactor < 0){
						rightRotate(leftRotate(root));
					}else if (childBalanceFactor > 0 || childBalanceFactor == 0){
						leftRotate(root);
					}
				}
				
				return root;
	}
}
