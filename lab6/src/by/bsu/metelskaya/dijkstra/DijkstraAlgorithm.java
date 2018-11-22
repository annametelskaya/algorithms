package by.bsu.metelskaya.dijkstra;

public class DijkstraAlgorithm {

    static int minDistance(int distant[], Boolean used[], int number) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < number; v++)
            if (!used[v] && distant[v] <= min) {
                min = distant[v];
                minIndex = v;
            }
        return minIndex;
    }

    static void dijkstra(int graph[][], int start, int finish, int number) {
        int distant[] = new int[number];
        Boolean used[] = new Boolean[number];
        for (int i = 0; i < number; i++) {
            distant[i] = Integer.MAX_VALUE;
            used[i] = false;
        }
        distant[start] = 0;

        for (int count = 0; count < number - 1; count++) {
            int u = minDistance(distant, used, number);
            used[u] = true;
            for (int v = 0; v < number; v++)
                if (!used[v] && graph[u][v] != 0 &&
                        distant[u] != Integer.MAX_VALUE &&
                        distant[u] + graph[u][v] < distant[v])
                    distant[v] = distant[u] + graph[u][v];
        }
        System.out.println("From vertex " + (start + 1) +
                " to vertex " + (finish + 1) + " " + distant[finish]);
    }
}