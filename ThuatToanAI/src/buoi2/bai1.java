package buoi2;

public class bai1 {

    // Hàm tính hệ số hồi quy đơn
    public static double calculateBeta1(double[] x, double[] y) {
        int n = x.length;
        double sumXY = 0;
        double sumX = 0;
        double sumY = 0;
        double sumXSquare = 0;
        
        // Tính tổng các giá trị
        for (int i = 0; i < n; i++) {
            sumXY += x[i] * y[i];
            sumX += x[i];
            sumY += y[i];
            sumXSquare += x[i] * x[i];
        }
        
        // Tính hệ số hồi quy đơn
        double beta1 = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
        
        return beta1;
    }
    
    public static void main(String[] args) {
        // Dữ liệu mẫu
        double[] x = {523, 645, 708, 1034, 2290, 2545};
        double[] y = {100, 150, 200, 300, 350, 440};
        
        // Tính hệ số hồi quy đơn
        double beta1 = calculateBeta1(x, y);
        
        // In kết quả
        System.out.println("Hệ số hồi quy đơn (beta_1) là: " + beta1);
    }
}
