import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    public SachGiaoKhoa() {
        super();
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tình trạng sách (moi / cu): ");
        tinhTrang = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" | Tình trạng: " + tinhTrang + " | Thành tiền: " + thanhTien());
    }

    @Override
    public double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }
}