package UI;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UNITSDAO;
import VO.SUPPLIES;
import VO.UNITS;

import javax.swing.JScrollPane;

public class USERUI extends JFrame {
	private UNITSDAO dao;
	private JTable haveTable;
	private JTable requestTable;

	public USERUI() {
		setSize(916, 600);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("\uBCF4\uAE09\uD488 \uBCF4\uC720\uD604\uD669");
		label.setBounds(17, 51, 212, 27);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\uBCF4\uAE09\uD488 \uC2E0\uCCAD\uB0B4\uC5ED");
		label_1.setBounds(265, 51, 212, 27);
		getContentPane().add(label_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(265, 113, 212, 387);
		getContentPane().add(scrollPane_1);

		requestTable = new JTable();
		scrollPane_1.setViewportView(requestTable);

		setVisible(true);

	}

	public void makeHaveTable() {
		dao = new UNITSDAO();
		String columnNames[] = { "품명", "종명", "수량" };
		ArrayList<SUPPLIES> sList = dao.sList();
		ArrayList<SUPPLIES> resList = new ArrayList<>();
		ArrayList<UNITS> ar = dao.ar();

		Collections.sort(sList);
		for (int i = 0; i < sList.size(); i++) {
			if (!ar.get(i).getUnits_seq().equals("1")&&ar.get(i).getUnits_seq().equals(sList.get(i).getUnits_seq())) {
				resList.add(sList.get(i));
			}
		}
		Object rowData[][] = new Object[resList.size()][3];
		System.out.println(resList);
		for (int i = 0; i < resList.size(); i++) {
			rowData[i][0] = sList.get(i).getSupplies_name();// 품명
			rowData[i][1] = sList.get(i).getSupply_class();// 종명
			rowData[i][2] = sList.get(i).getSupplies_quantity();// 수량

		}
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		haveTable = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 113, 212, 387);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(haveTable);

	}

}
