package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.CustomerBo;
import lk.ijse.semisterfinal.Dao.Custom.CustomerDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.CustomerDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.CusromerDTO;
import lk.ijse.semisterfinal.entity.AddEmployeeEntity;
import lk.ijse.semisterfinal.entity.CusromerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.CUSTOMER);

    @Override
    public boolean add(CusromerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDao.add(new CusromerEntity(dto.getTxtCustId(),dto.getTxtCustAddress(),
                dto.getTxtCustName(),dto.getTxtCustMobile(),
                dto.getTxtCustPayment()));
    }

    @Override
    public boolean delete(CusromerDTO id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(new CusromerEntity(id.getTxtCustId()));
    }

    @Override
    public boolean update(CusromerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new CusromerEntity(dto.getTxtCustId(),dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),
                dto.getTxtCustPayment()));
    }

    @Override
    public ArrayList<CusromerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CusromerEntity> entities = customerDao.getAll();
        ArrayList<CusromerDTO> dtos = new ArrayList<>();
        for (CusromerEntity dto : entities){
            dtos.add(new CusromerDTO(dto.getTxtCustId(),dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),
                    dto.getTxtCustPayment()));
        }
        return dtos;

    }

    @Override
    public CusromerDTO searchCustomer(String id) throws SQLException {
        CusromerEntity dto = customerDao.searchCustomer(id);
        return new CusromerDTO(dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),
                dto.getTxtCustPayment(),dto.getTxtCustId());
    }
}
