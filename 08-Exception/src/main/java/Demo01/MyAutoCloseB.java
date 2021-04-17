package Demo01;

import java.io.IOException;

class MyAutoCloseB implements AutoCloseable {

    public void test() throws IOException {
        System.out.println("MyAutoCloaseB: test()");
        throw new IOException("MyAutoCloaseB: test() IOException");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseB: on close()");
        throw new ClassNotFoundException("MyAutoCloaseB: close() ClassNotFoundException");
    }
}