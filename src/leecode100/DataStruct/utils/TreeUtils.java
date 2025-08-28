package leecode100.DataStruct.utils;

import leecode100.DataStruct.TreeNode;

import java.util.*;

public class TreeUtils {
    /**
     * 打印二叉树结构
     * @param root 二叉树根节点
     */
    public static void printTree(TreeNode root) {
        // 使用简洁紧凑的打印方法
        printCompactTree(root);
    }
    
    /**
     * 紧凑格式打印二叉树
     * @param root 根节点
     */
    public static void printCompactTree(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        
        // 获取树的高度
        int height = getHeight(root);
        
        // 创建一个字符矩阵来表示树
        // 每层一行，每个节点占一个位置
        int width = (1 << height) - 1;
        String[][] res = new String[height][width];
        for (String[] arr : res) {
            Arrays.fill(arr, " ");
        }
        
        // 填充矩阵
        fill(res, root, 0, 0, width - 1);
        
        // 打印矩阵
        for (String[] arr : res) {
            for (String s : arr) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
    
    /**
     * 填充矩阵
     */
    private static void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null) return;
        
        int mid = l + (r - l) / 2;
        res[i][mid] = String.valueOf(root.val);
        
        fill(res, root.left, i + 1, l, mid - 1);
        fill(res, root.right, i + 1, mid + 1, r);
    }
    
    /**
     * 另一种紧凑的打印方式
     * @param root 根节点
     */
    public static void printNiceTree(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        
        // 获取树的字符串表示
        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        
        level.add(root);
        int nn = 1;
        int widest = 0;
        
        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;
            
            for (TreeNode node : level) {
                if (node == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(node.val);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();
                    
                    next.add(node.left);
                    next.add(node.right);
                    
                    if (node.left != null) nn++;
                    if (node.right != null) nn++;
                }
            }
            
            if (widest % 2 == 1) widest++;
            
            lines.add(line);
            
            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }
        
        // 打印树
        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;
            
            if (i > 0) {
                // 打印连接线
                for (int j = 0; j < line.size(); j++) {
                    // 打印左连接线
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);
                    
                    // 打印连接线
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }
            
            // 打印节点值
            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
                
                // 打印节点前的间隔
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                // 打印节点值
                System.out.print(f);
                // 打印节点后的间隔
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            
            perpiece /= 2;
        }
    }
    
    /**
     * 最简单的打印方式
     * @param root 根节点
     */
    public static void printSimpleTree(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        
        int height = getHeight(root);
        int width = (1 << height) * 2;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        queue.offer(root);
        posQueue.offer(width / 2);
        
        for (int i = 0; i < height; i++) {
            int size = queue.size();
            String line = "";
            String connectLine = "";
            
            // 初始化行字符串
            for (int j = 0; j < width; j++) {
                line += " ";
                connectLine += " ";
            }
            
            char[] lineChars = line.toCharArray();
            char[] connectChars = connectLine.toCharArray();
            
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                int position = posQueue.poll();
                
                // 设置节点值
                lineChars[position] = (char) (node.val + '0');
                
                // 处理左子树
                if (node.left != null) {
                    queue.offer(node.left);
                    int leftPos = position - (1 << (height - i - 2));
                    posQueue.offer(leftPos);
                    
                    // 设置左连接线
                    for (int k = leftPos + 1; k < position; k++) {
                        connectChars[k] = '-';
                    }
                    connectChars[leftPos] = '/';
                }
                
                // 处理右子树
                if (node.right != null) {
                    queue.offer(node.right);
                    int rightPos = position + (1 << (height - i - 2));
                    posQueue.offer(rightPos);
                    
                    // 设置右连接线
                    for (int k = position + 1; k < rightPos; k++) {
                        connectChars[k] = '-';
                    }
                    connectChars[rightPos] = '\\';
                }
            }
            
            // 打印当前行
            System.out.println(new String(lineChars));
            if (i < height - 1) {
                System.out.println(new String(connectChars));
            }
        }
    }
    
    /**
     * 最佳打印方式
     * @param root 根节点
     */
    public static void printTreeBest(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        
        // 获取树的高度
        int height = getHeight(root);
        
        // 初始化节点位置
        int[][] nodePositions = new int[height][2 << height];
        for (int i = 0; i < height; i++) {
            Arrays.fill(nodePositions[i], -1);
        }
        
        // 计算节点位置
        calculateNodePositions(root, 0, 0, 2 << height, nodePositions);
        
        // 创建输出矩阵
        char[][] output = new char[height * 2 - 1][2 << height];
        for (char[] row : output) {
            Arrays.fill(row, ' ');
        }
        
        // 填充节点和连接线
        fillOutput(root, 0, nodePositions, output);
        
        // 打印结果
        for (char[] row : output) {
            boolean hasContent = false;
            for (char c : row) {
                if (c != ' ') {
                    hasContent = true;
                    break;
                }
            }
            if (hasContent) {
                System.out.println(new String(row));
            }
        }
    }
    
    /**
     * 计算节点位置
     */
    private static void calculateNodePositions(TreeNode node, int level, int left, int right, int[][] positions) {
        if (node == null) return;
        
        int mid = (left + right) / 2;
        positions[level][mid] = node.val;
        
        calculateNodePositions(node.left, level + 1, left, mid, positions);
        calculateNodePositions(node.right, level + 1, mid + 1, right, positions);
    }
    
    /**
     * 填充输出矩阵
     */
    private static void fillOutput(TreeNode node, int level, int[][] positions, char[][] output) {
        if (node == null) return;
        
        // 找到当前节点的位置
        int pos = -1;
        for (int i = 0; i < positions[level].length; i++) {
            if (positions[level][i] == node.val) {
                pos = i;
                break;
            }
        }
        
        // 设置节点值
        output[level * 2][pos] = (char) (node.val + '0');
        
        // 处理左子树
        if (node.left != null) {
            // 找到左子节点的位置
            int leftPos = -1;
            for (int i = 0; i < positions[level + 1].length; i++) {
                if (positions[level + 1][i] == node.left.val) {
                    leftPos = i;
                    break;
                }
            }
            
            // 绘制连接线
            output[level * 2 + 1][leftPos] = '/';
            for (int i = leftPos + 1; i < pos; i++) {
                output[level * 2 + 1][i] = '-';
            }
            
            // 递归处理左子树
            fillOutput(node.left, level + 1, positions, output);
        }
        
        // 处理右子树
        if (node.right != null) {
            // 找到右子节点的位置
            int rightPos = -1;
            for (int i = 0; i < positions[level + 1].length; i++) {
                if (positions[level + 1][i] == node.right.val) {
                    rightPos = i;
                    break;
                }
            }
            
            // 绘制连接线
            output[level * 2 + 1][rightPos] = '\\';
            for (int i = pos + 1; i < rightPos; i++) {
                output[level * 2 + 1][i] = '-';
            }
            
            // 递归处理右子树
            fillOutput(node.right, level + 1, positions, output);
        }
    }
    
    /**
     * 获取树的高度
     * @param node 节点
     * @return 高度
     */
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    /**
     * 层序遍历打印二叉树
     * @param root 根节点
     */
    public static void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("第" + (level + 1) + "层: ");
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            System.out.println();
            level++;
        }
    }
    
    /**
     * 打印二叉树的水平方向可视化
     * @param root 根节点
     */
    public static void printTreeHorizontal(TreeNode root) {
        printNodeInternalHorizontal(root, "", true);
    }
    
    /**
     * 内部递归方法，用于水平打印树结构
     * @param node 当前节点
     * @param prefix 前缀字符串
     * @param isTail 是否是尾节点
     */
    private static void printNodeInternalHorizontal(TreeNode node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }
        
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);
        
        if (node.left != null || node.right != null) {
            if (node.right != null) {
                printNodeInternalHorizontal(node.right, prefix + (isTail ? "    " : "│   "), node.left == null);
            }
            
            if (node.left != null) {
                printNodeInternalHorizontal(node.left, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
}

