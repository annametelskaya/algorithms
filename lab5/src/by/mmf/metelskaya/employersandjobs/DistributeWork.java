package by.mmf.metelskaya.employersandjobs;

class DistributeWork {
    private int size;
    private int countBusyEmployers;
    private int[][] speedMatrix;
    private int[][] priorityMatrix;
    private boolean[] busyEmployees;
    private int[] completedJobs;

    DistributeWork(int[][] speed, int[][] priority) {
        size = speed.length;
        countBusyEmployers = 0;
        speedMatrix = speed;
        priorityMatrix = priority;
        busyEmployees = new boolean[size];
        completedJobs = new int[size];
        for (int i = 0; i < size; i++)
            completedJobs[i] = 0;
    }

    void calculateMatches() {
        while (countBusyEmployers < size) {
            for (int free = 0; free < size; free++) {
                if (!busyEmployees[free]) {
                    for (int i = 0; i < size && !busyEmployees[free]; i++) {
                        int index = speedMatrix[free][i] - 1;
                        if (completedJobs[index] == 0) {
                            completedJobs[index] = free + 1;
                            busyEmployees[free] = true;
                            countBusyEmployers++;
                        } else {
                            int current = completedJobs[index];
                            if (morePreference(current, free + 1, index)) {
                                completedJobs[index] = free + 1;
                                busyEmployees[free] = true;
                                busyEmployees[current - 1] = false;
                            }
                        }
                    }
                }
            }
        }
        print();

    }
    private boolean morePreference(int current, int newPartner, int index) {
        for (int i = 0; i < size; i++) {
            if (priorityMatrix[index][i] == newPartner)
                return true;
            if (priorityMatrix[index][i] == current)
                return false;
        }
        return false;
    }

    private void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("employer " + (1 + i) + " job " + completedJobs[i]);
        }
    }
}
