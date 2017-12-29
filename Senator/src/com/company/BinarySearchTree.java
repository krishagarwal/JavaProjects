package com.company;

import java.util.Scanner;

class BinarySearchTree {
    private TreeNode first;

    BinarySearchTree() {
        first = null;
    }

    TreeNode getFirst(){
        return first;
    }

    private TreeNode add(TreeNode parent, TreeNode node){
        Senator senOne = (Senator)parent.getValue();
        Senator senTwo = (Senator)node.getValue();

        if(senOne.compareTo(senTwo) > 0){
            if(parent.getLeft() == null){
                parent.setLeft(node);
            } else {
                add(parent.getLeft(), node);
            }
        } else{
            if(parent.getRight() == null){
                parent.setRight(node);
            } else {
                add(parent.getRight(), node);
            }
        }

        return parent;
    }

    //________________________________________________________________________________________________________________________________

    void printList(TreeNode node)
    {
        if(node == null){
            return;
        }

        if(node.getLeft() != null){
            printList(node.getLeft());
        }

        System.out.println(node.getValue());

        if(node.getRight() != null){
            printList(node.getRight());
        }
    }

    //--------------------------------------------------

    void loadData(String fileName){
        this.clear();
        Scanner myScan = OpenFile.openToRead(fileName);

        while(myScan.hasNext()){
            Senator newSenator = new Senator(myScan.next(), myScan.nextInt(),
                    myScan.nextInt(), myScan.nextInt(), myScan.nextInt(),
                    myScan.next(), myScan.next(), myScan.nextInt(),
                    myScan.nextInt(), myScan.nextInt());

            TreeNode node = new TreeNode(newSenator, null, null);
            if(first == null){
                first = node;
            } else{
                add(first, node);
            }
        }
    }

    //--------------------------------------------------
    void clear(){
        first = null;
    }
    //--------------------------------------------------
    boolean deleteSenator(String name){
         return hasDeleted(name);
    }
    //delete all senators in list. bernie sanders deletion.delete leaves, delete the parents, nonexistent. try q-ing
    //change "by name"

    private boolean hasDeleted(String name){
        TreeNode delete = find(first, name);
        if(delete == null){
            return false;
        }

        TreeNode left = getLeftMost(delete.getRight());
        if(left != null){
            TreeNode parent = findParent(first, left);
            delete.setValue(left.getValue());
            if(delete == parent){
                parent.setRight(null);
            }else{
                parent.setLeft(null);
            }
            return true;
        }

        TreeNode right = getRightMost(delete.getLeft());
        if(right != null){
            TreeNode parent = findParent(first, right);
            delete.setValue(right.getValue());
            if(delete == parent){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
            return true;
        }

        TreeNode parent = findParent(first, delete);
        if(parent.getRight() == delete){
            parent.setRight(null);
            return true;
        } else if(parent.getLeft() == delete){
            parent.setLeft(null);
            return true;
        }

        return false;
    }

    private TreeNode findParent(TreeNode current, TreeNode child){
        if(current == null){
            return null;
        }

        if(current.getRight() == child || current.getLeft() == child){
            return current;
        }
        Senator currentSen = (Senator)current.getValue();
        Senator childSen = (Senator)child.getValue();

        if(currentSen.compareTo(childSen) < 0){
            return findParent(current.getRight(), child);
        } else{
            return findParent(current.getLeft(), child);
        }

    }

    private TreeNode getLeftMost(TreeNode node){
        if(node == null){
            return null;
        } else if(node.getLeft() == null){
            return node;
        }

        return getLeftMost(node.getLeft());
    }

    private TreeNode getRightMost(TreeNode node){
        if(node == null){
            return null;
        } else if(node.getRight() == null){
            return node;
        }

        return getRightMost(node.getRight());
    }

    //--------------------------------------------------
    Object findSenator(String name){
        return (find(first, name).getValue());
    }

    private TreeNode find(TreeNode parent, String name){
        if(parent == null){
            return null;
        }

        Senator sen = (Senator)parent.getValue();
        String senName = sen.getName().toLowerCase();
        name = name.toLowerCase();

        if(senName.equalsIgnoreCase(name)){
            return parent;
        } else if(senName.compareTo(name) < 0){
            return find(parent.getRight(), name);
        } else{
            return find(parent.getLeft(), name);
        }
    }
    //--------------------------------------------------
    int size(){
        return count(first);
    }

    private int count(TreeNode node){
        if(node == null){
            return 0;
        }

        return 1 + count(node.getLeft()) + count(node.getRight());
    }


}

