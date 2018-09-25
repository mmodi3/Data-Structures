package trees;

public class BSTree<E extends Comparable<E>> extends BinTree<E> {
	
	//Constructors
	
	BSTree(){
		super();
	}
	
	BSTree(E data){
		super(data);
	}
	
	BSTree(E data, BSTree<E> left, BSTree<E> right){
		super(data,left,right);
	}
	
	//Methdos
	private boolean find(E key, Node<E> n) {
		if (n == null) {
			return false;
		} else {
			int comparison = n.data.compareTo(key);
			if (comparison == 0) {
				return true;
			} else {
				if (comparison < 0) {
					return find(key, n.right);
				} else {
					return find(key, n.left);
				}		
			}
		}
	}
		
	public boolean find(E key){
		return find(key, root);
	}
	
	private E max(Node<E> n) {
		if (n == null) {
			return null;
		}
		if (n.right.right == null) {
			return n.right.data;
		} else {
			return max(n.right);
		}
	}
	
	public E max(){
		return max(root);
	}
	
	private E removeMax(Node<E> n) {
		if (n == null) {
			throw new IllegalStateException();
		} 
		if (n.right.right == null) {
			E temp = n.right.data;
			if (n.right.left == null) {
				n.right = null;
			} else {
				n = n.right.left;
			}
			return temp;
		} else {
			return removeMax(n.right);
		}
	}
	
	private E findAndRemoveMax(Node<E> n) {
		if (n.right.right == null) {
			E temp = n.right.data;
			n.right = n.right.left;
			return temp;
		} else {
			return findAndRemoveMax(n.right);
		}
	}
	
	
	public E removeMax() {
		return removeMax(root);
	}
	
	public E remove(E key){
		root = remove(key, root);
		return key;
	}
	
	private Node<E> remove(E key, Node<E> n){
		if (n == null) {
			return null;
		} else {
			int comparison = n.data.compareTo(key);
			if (comparison < 0) {
				n.right = remove(key, n.right);
				return n;
			} else {
				if (comparison > 0) {
					n.left = remove(key, n.left);
					return n;
				} else {
					if (n.right == null) {
						return n.left;
					} else if (n.left == null) {
						return n.right;
					} else {
						Node<E> curr = n.left;
						if (curr.right != null) {
							while (curr.right.right != null) {
								curr = curr.right;
							}
							if (curr.right.left == null) {
								n.data = curr.right.data;
								curr.right = null;
								return n;
							} else {
								n.data = curr.right.data;
								curr.right = curr.right.left;
								return n;
							}
						} else {
						n.data = curr.data;
						curr = null;
						return n;
						}	
					}
				}
			}
		}
	}

	
	public static void main(String[] args) {
		BSTree<Integer> t1 = new BSTree<Integer>(23, new BSTree<Integer>(12), new BSTree<Integer>(27));
		BSTree<Integer> t2 = new BSTree<Integer>(43, new BSTree<Integer>(), new BSTree<Integer>(74));
		BSTree<Integer> t = new BSTree<Integer>(34, t1, t2);
		
		System.out.println(t);
		t.remove(23);
		System.out.println(t);
	}
	

}
