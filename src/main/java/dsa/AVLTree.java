package dsa;

public class AVLTree<K extends Comparable<K>> {
    private static class AVLNode<K extends Comparable<K>> {
        private int height;
        private K key;
        private AVLNode<K> left = null, right = null;

        public AVLNode(K e) {
            key = e;
            height = 1;
        }

        public K getKey() {
            return key;
        }

        public AVLNode<K> getLeft() {
            return left;
        }

        public AVLNode<K> getRight() {
            return right;
        }

        public void setLeft(AVLNode<K> n) {
            left = n;
        }

        public void setRight(AVLNode<K> n) {
            right = n;
        }

        public void updateHeight() {
            int l = (left == null) ? 0 : left.height;
            int r = (right == null) ? 0 : right.height;
            height = Math.max(l, r) + 1;
        }

        public int getBalance() {
            int l = (left == null) ? 0 : left.height;
            int r = (right == null) ? 0 : right.height;
            return l - r;
        }
    }

    private AVLNode<K> root;

    public void insert(K k) {
        //output for visualization
        System.out.println("insert(" + k + ")");
        if (root == null)
            root = new AVLNode<>(k);
        else
            root = insertNode(root, k);
    }

    private AVLNode<K> insertNode(AVLNode<K> n, K k) {
        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            // key already exists, there's nothing to do
        } else if (cmp < 0) {

            if (n.getRight() != null) {

                n.setRight(insertNode(n.getRight(), k));
            } else {

                n.setRight(new AVLNode<>(k));
            }

            n.updateHeight();

            if (n.getBalance() < -1) {

                if (n.getRight().getBalance() < 0) {

                    System.out.println("L("
                            + n.getRight().getKey() + ","
                            + n.getKey() + ")");
                    n = rotateLeft(n);
                } else {

                    System.out.println("DR("
                            + n.getRight().getLeft().getKey() + ","
                            + n.getRight().getKey() + ","
                            + n.getKey() + ")");
                    n.setRight(rotateRight(n.getRight()));
                    n = rotateLeft(n);
                }
            }
        } else {

            if (n.getLeft() != null) {

                n.setLeft(insertNode(n.getLeft(), k));
            } else {

                n.setLeft(new AVLNode<>(k));
            }

            n.updateHeight();

            if (n.getBalance() > 1) {

                if (n.getLeft().getBalance() > 0) {

                    System.out.println("R("
                            + n.getLeft().getKey() + ","
                            + n.getKey() + ")");
                    n = rotateRight(n);
                } else {

                    System.out.println("DL("
                            + n.getLeft().getRight().getKey() + ","
                            + n.getLeft().getKey() + ","
                            + n.getKey() + ")");
                    n.setLeft(rotateLeft(n.getLeft()));
                    n = rotateRight(n);
                }
            }
        }

        return n;
    }

    private AVLNode<K> rotateLeft(AVLNode<K> n) {
        AVLNode<K> tmp = n.getRight();
        n.setRight(tmp.getLeft());
        n.updateHeight();
        tmp.setLeft(n);
        tmp.updateHeight();
        return tmp;
    }

    private AVLNode<K> rotateRight(AVLNode<K> n) {
        AVLNode<K> tmp = n.getLeft();
        n.setLeft(tmp.getRight());
        n.updateHeight();
        tmp.setRight(n);
        tmp.updateHeight();
        return tmp;
    }
}
