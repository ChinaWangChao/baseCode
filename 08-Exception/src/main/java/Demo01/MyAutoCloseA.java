package Demo01;

import java.io.IOException;

class MyAutoCloseA implements AutoCloseable {

    public void test() throws IOException {
        System.out.println("MyAutoCloaseA: test()");
        throw new IOException("MyAutoCloaseA: test() IOException");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseA: on close()");
        throw new ClassNotFoundException("MyAutoCloaseA: close() ClassNotFoundException");
    }
}