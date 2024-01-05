import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day7 {

    public static void main(String[] args) throws IOException {
        //first part
        List<String> lines = Files.readAllLines(new File("src/main/Day7.txt").toPath());
        lines.remove(0);
        System.out.println(lines);
        Node<String> rootNode = new Node<>("/");
        System.out.println(rootNode.isRoot());
        Node<String> childNode = new Node<>(null);
        Map<String, Integer> file = new HashMap<>();
        int sizeOfFilesystem = lines.size();
        for (int line = 0; line < sizeOfFilesystem; line++) {
            if (lines.get(line).contains("$ ls")) {
                line++;
                if (lines.get(line).startsWith("dir")) {
                    childNode.addChild(lines.get(line).substring(4));
                }
                if (lines.get(line).startsWith("$ cd ..")) {


                }


                if (Integer.parseInt(String.valueOf(lines.get(line).indexOf(0))) < 10 ) {
                    String[] sizeAndName = lines.get(line).split(" ");
                    int size = Integer.parseInt(sizeAndName[0]);
                    String name = sizeAndName[1];
                    file.put(name, size);
                    rootNode.addChild(lines.get(line));

                }
            }

        }



    }

    public static class Node<T> {
        private List<Node<T>> children = new ArrayList<Node<T>>();
        private Node<T> parent = null;
        private T data = null;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public void setParent(Node<T> parent) {
            parent.addChild(this);
            this.parent = parent;
        }

        public void addChild(T data) {
            Node<T> child = new Node<T>(data);
            child.setParent(this);
            this.children.add(child);
        }

        public void addChild(Node<T> child) {
            child.setParent(this);
            this.children.add(child);
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isRoot() {
            return (this.parent == null);
        }

        public void removeParent() {
            this.parent = null;
        }
    }
}