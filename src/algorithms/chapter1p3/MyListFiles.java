package algorithms.chapter1p3;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * p1.3.43 文件列表。文件夹就是一列文件和文件夹的列表。编写一个程序，从命令行
 * 接受一个文件夹名作为参数，打印出该文件夹下的所有文件并用递归的方式在所有子文件夹
 * 的名下缩进列出其下的所有文件。
 */
public class MyListFiles {
    public static void listAllFiles(String path,int dep){
        File f = new File(path);
        File[] list = f.listFiles();
        for (File newFile:list
             ) {
            for (int i = 0; i < dep; i++) {
                StdOut.print("\t");
            }
            StdOut.println(newFile.getName());
            if (newFile.isDirectory()){
                listAllFiles(newFile.getAbsolutePath(),dep+1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        String path = "C:\\Program Files\\Java\\jre1.8.0_181";
        StdOut.println(path);
        listAllFiles(path,0);
    }
}
