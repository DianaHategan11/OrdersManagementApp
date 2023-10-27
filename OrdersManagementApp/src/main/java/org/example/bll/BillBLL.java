package org.example.bll;

import org.example.dao.BillDAO;
import org.example.model.Bill;

import javax.swing.*;
import java.util.List;

/**
 * The BillBLL class is responsible for handling business logic operations related to bills.
 */
public class BillBLL {
    private BillDAO billDAO;

    /**
     * Constructs a new BillBll object.
     */
    public BillBLL() {
        this.billDAO = new BillDAO();
    }

    /**
     * Retrieves all bills from the database.
     *
     * @return a list of all bills
     */
    public List<Bill> findAllBillsDB() {
        return billDAO.findAllBills();
    }

    /**
     * Inserts a bill into the database.
     *
     * @param bill the bill to be inserted
     */
    public void insertBill(Bill bill) {
        billDAO.insert(bill);
    }

    /**
     * Generates a JTable representation of a list of bills.
     *
     * @param listOfBills the list of bills to be displayed in the table
     * @return a JTable containing the bills' data
     */
    public JTable generateBillsTable(List<Bill> listOfBills) {
        return billDAO.generateTable(listOfBills);
    }
}
