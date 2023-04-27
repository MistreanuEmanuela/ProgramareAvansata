public class ThreadPlayer extends Thread{
        private Exploration explore;
        private int timeLimit;
        private boolean timeUp;

        public ThreadPlayer(Exploration explore, int timeLimit) {
            this.explore = explore;
            this.timeLimit = timeLimit;
            this.timeUp = false;
            setDaemon(true);
        }

        public void run() {
            long startTime = System.currentTimeMillis();

            while (!timeUp) {
                long elapsedTime = System.currentTimeMillis() - startTime;
              //  System.out.println("Your time : " + elapsedTime/1000 + "seconds");
                if (elapsedTime >= timeLimit * 1000) {
                    timeUp = true;
                    System.out.println("Time limit of " + timeLimit + " seconds exceeded. Stopping exploration.");
                }

                try {
                    Thread.sleep(1000); // Update once per second
                } catch (InterruptedException e) {
                    // Ignore
                }
            }

            System.exit(-1); // Stop the exploration
        }
    }

