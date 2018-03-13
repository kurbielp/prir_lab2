package prir3;
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    int number;
    MatrixMult.Matrix A;
    MatrixMult.Matrix B;
    MatrixMult.Matrix C;

    ThreadDemo(String name, int number, MatrixMult.Matrix A, MatrixMult.Matrix B, MatrixMult.Matrix C) {
        threadName = name;
        System.out.println("Creating " +  threadName );
        this.number = number;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    //@Override
    public void run() {
        System.out.println("Running " +  threadName );


        int r = number;
            for (int c = 0; c < B.cols(); c++) {
                float s = 0;
                for (int k = 0; k < A.cols(); k++) {
                    s += A.get(r, k) * B.get(k, c);
                }
                C.set(r, c, s);
                System.out.print(C.rows());

                System.out.print("\n");



        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

