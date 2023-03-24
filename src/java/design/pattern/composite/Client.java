package design.pattern.composite;

/**
 * @author liuxucheng
 * @since 2022/12/28
 */
public class Client {

    public static void main(String[] args) {
        Directory fileSystemTree = new Directory("/");
        Directory nodeWz = new Directory("/wz/");
        Directory nodeXzg = new Directory("/xzg/");
        fileSystemTree.addChild(nodeWz);
        fileSystemTree.addChild(nodeXzg);

        File nodeWzA = new File("/wz/a.txt");
        File nodeWzB = new File("/wz/b.txt");
        Directory nodeWzMovies = new Directory("/wz/movies/");
        nodeWz.addChild(nodeWzA);
        nodeWz.addChild(nodeWzB);
        nodeWz.addChild(nodeWzMovies);

        File nodeWzMoviesC = new File("/wz/movies/c.avi");
        nodeWzMovies.addChild(nodeWzMoviesC);

        Directory nodeXzgDocs = new Directory("/xzg/docs/");
        nodeXzg.addChild(nodeXzgDocs);

        File nodeXzgDocsD = new File("/xzg/docs/d.txt");
        nodeXzgDocs.addChild(nodeXzgDocsD);

        System.out.println("/ files num:" + fileSystemTree.countNumOfFiles());
        System.out.println("/wz/ files num:" + nodeWz.countNumOfFiles());
    }
}
