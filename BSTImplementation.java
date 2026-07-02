public class BSTImplementation {

    // Node Class
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    TreeNode root;

    // Insert
    TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Search
    boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Find Minimum Node
    TreeNode minValue(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete
    TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            // Node with one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            TreeNode temp = minValue(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    // Inorder Traversal
    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal
    void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal
    void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main Method
    public static void main(String[] args) {
        BSTImplementation bst = new BSTImplementation();

        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 70);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 40);
        bst.root = bst.insert(bst.root, 60);
        bst.root = bst.insert(bst.root, 80);

        System.out.print("Inorder: ");
        bst.inorder(bst.root);

        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);

        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);

        System.out.println("\n\nSearch 40: "
                + bst.search(bst.root, 40));

        bst.root = bst.delete(bst.root, 30);

        System.out.print("After deleting 30 (Inorder): ");
        bst.inorder(bst.root);
    }
}
