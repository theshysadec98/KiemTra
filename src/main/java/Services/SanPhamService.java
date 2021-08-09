package Services;

import DAO.ManagerSanPham;
import Models.SanPham;

import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamService {
    public ArrayList<SanPham> list = new ArrayList<>();

    public SanPhamService(){
        try {
            list = (ArrayList<SanPham>) ManagerSanPham.seclect();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(SanPham sanPham) throws SQLException {
        ManagerSanPham.create(sanPham);
        list.add(sanPham);
    }

    public void edit(SanPham sanPham,int index) throws SQLException {
        ManagerSanPham.edit(sanPham);
        list.set(index,sanPham);
    }

    public void delete(int index) throws SQLException {
        ManagerSanPham.delete(list.get(index).getId());
        list.remove(index);
    }

    public ArrayList<SanPham> findByName(String name) throws SQLException {
        return ManagerSanPham.findByName(name);
    }

}
