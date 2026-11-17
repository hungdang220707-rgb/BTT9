import java.util.ArrayList;
import java.util.Scanner;

class Sach {
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
class SachGiaoKhoa extends Sach {
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
class SachThamKhao extends Sach {
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
public class Tuan9 {
    public static void main(String[] args) {
        ArrayList<Sach> danhSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n--- CHƯƠNG TRÌNH QUẢN LÝ SÁCH ---");
            System.out.println("1. Nhập danh sách sách (SGK hoặc Sách tham khảo)");
            System.out.println("2. Xuất danh sách các loại sách");
            System.out.println("3. Tính tổng thành tiền cho từng loại sách");
            System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
            System.out.println("5. Xuất danh sách sách giáo khoa của nhà xuất bản X");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            chon = scanner.nextInt();
            scanner.nextLine(); // Bỏ dòng thừa
            switch (chon) {
                case 1:
                    System.out.print("Bạn muốn nhập sách nào? (1: Sách giáo khoa, 2: Sách tham khảo): ");
                    int loai = scanner.nextInt();
                    scanner.nextLine();
                    if (loai == 1) {
                        Sach sgk = new SachGiaoKhoa();
                        System.out.println("--- Nhập thông tin Sách giáo khoa ---");
                        sgk.nhap();
                        danhSach.add(sgk);
                    } else if (loai == 2) {
                        Sach stk = new SachThamKhao();
                        System.out.println("--- Nhập thông tin Sách tham khảo ---");
                        stk.nhap();
                        danhSach.add(stk);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH CÁC LOẠI SÁCH ---");
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (int i = 0; i < danhSach.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            danhSach.get(i).xuat();
                        }
                    }
                    break;

                case 3:
                    double tongTienSGK = 0;
                    double tongTienSTK = 0;
                    for (Sach s : danhSach) {
                        if (s instanceof SachGiaoKhoa) {
                            tongTienSGK += s.thanhTien();
                        } else if (s instanceof SachThamKhao) {
                            tongTienSTK += s.thanhTien();
                        }
                    }
                    System.out.println("\n--- TỔNG THÀNH TIỀN ---");
                    System.out.println("Tổng thành tiền Sách giáo khoa: " + tongTienSGK);
                    System.out.println("Tổng thành tiền Sách tham khảo: " + tongTienSTK);
                    break;

                case 4:
                    double tongDonGiaSTK = 0;
                    int demSTK = 0;
                    for (Sach s : danhSach) {
                        if (s instanceof SachThamKhao) {
                            tongDonGiaSTK += s.getDonGia();
                            demSTK++;
                        }
                    }
                    System.out.println("\n--- TRUNG BÌNH CỘNG ĐƠN GIÁ SÁCH THAM KHẢO ---");
                    if (demSTK == 0) {
                        System.out.println("Không có sách tham khảo nào trong danh sách!");
                    } else {
                        double trungBinh = tongDonGiaSTK / demSTK;
                        System.out.println("Đơn giá trung bình sách tham khảo: " + trungBinh);
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên nhà xuất bản X cần tìm: ");
                    String nxbX = scanner.nextLine();
                    System.out.println("\n--- SÁCH GIÁO KHOA CỦA NXB: " + nxbX + " ---");
                    boolean found = false;
                    for (Sach s : danhSach) {
                        if (s instanceof SachGiaoKhoa && s.getNhaXuatBao().equalsIgnoreCase(nxbX)) {
                            s.xuat();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách giáo khoa nào của nhà xuất bản này!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 5!");
            }
        } while (chon != 0);
    }
}