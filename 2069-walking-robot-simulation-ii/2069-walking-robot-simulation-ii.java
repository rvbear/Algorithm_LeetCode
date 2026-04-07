class Robot {
    int w, h, x, y, dir, per;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String[] dirNames = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.per = 2 * (w + h - 2);
    }
    
    public void step(int num) {
        if (per == 0) {
            return;
        }

        num %= per;
        
        if (num == 0) {
            num = per;
        }

        while (num-- > 0) {
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                dir = (dir + 1) % 4;
                nx = x + directions[dir][0];
                ny = y + directions[dir][1];
            }

            x = nx;
            y = ny;
        }
    }
    
    public int[] getPos() {
        return new int[] {x, y};
    }
    
    public String getDir() {
        return dirNames[dir];
    }
}
