import java.util.Scanner;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
        super();
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tiền thuế: ");
        thue = scanner.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" | Thuế: " + thue + " | Thành tiền: " + thanhTien());
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;
    }
}