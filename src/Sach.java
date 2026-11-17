import java.util.Scanner;

public class Sach {
    protected String maSach;
    protected String ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBao;

    public Sach() {
    }

    public Sach(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBao) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBao = nhaXuatBao;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        maSach = scanner.nextLine();
        System.out.print("Nhập ngày nhập (dd/mm/yyyy): ");
        ngayNhap = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        soLuong = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập nhà xuất bản: ");
        nhaXuatBao = scanner.nextLine();
    }

    public void xuat() {
        System.out.print("Mã sách: " + maSach + " | Ngày nhập: " + ngayNhap + " | Đơn giá: " + donGia + " | Số lượng: " + soLuong + " | NXB: " + nhaXuatBao);
    }

    public double thanhTien() {
        return 0;
    }

    public String getNhaXuatBao() {
        return nhaXuatBao;
    }

    public double getDonGia() {
        return donGia;
    }
}