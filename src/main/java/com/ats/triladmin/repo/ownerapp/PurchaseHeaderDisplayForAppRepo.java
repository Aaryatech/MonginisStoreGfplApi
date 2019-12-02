package com.ats.triladmin.repo.ownerapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ownerapp.PurchaseHeaderDisplayForApp;


public interface PurchaseHeaderDisplayForAppRepo extends JpaRepository<PurchaseHeaderDisplayForApp, Integer>{
	
	
	@Query(value=("SELECT\r\n" + 
			"    t1.mrn_id,\r\n" + 
			"    t1.po_id,\r\n" + 
			"    t1.mrn_date,\r\n" + 
			"    t1.vendor_id,\r\n" + 
			"    t1.vendor_name,\r\n" + 
			"    t1.bill_no,\r\n" + 
			"    t1.mrn_no,\r\n" + 
			"    t1.po_no,\r\n" + 
			"    t1.mrn_status,\r\n" + 
			"    COALESCE((t2.total_taxable_amt),\r\n" + 
			"    0) AS total_taxable_amt,\r\n" + 
			"    COALESCE((t2.total_tax_amt),\r\n" + 
			"    0) AS total_tax_amt,\r\n" + 
			"    COALESCE((t2.grand_total),\r\n" + 
			"    0) AS grand_total,\r\n" + 
			"    COALESCE((t2.total_disc_value),\r\n" + 
			"    0) AS total_disc_value,\r\n" + 
			"    COALESCE(\r\n" + 
			"        (t2.total_other_charges_before),\r\n" + 
			"        0\r\n" + 
			"    ) AS total_other_charges_before,\r\n" + 
			"    COALESCE(\r\n" + 
			"        (t2.total_other_charges_after),\r\n" + 
			"        0\r\n" + 
			"    ) AS total_other_charges_after\r\n" + 
			"FROM\r\n" + 
			"    (\r\n" + 
			"    SELECT\r\n" + 
			"        h.mrn_id,\r\n" + 
			"        d.po_id,\r\n" + 
			"        h.mrn_date,\r\n" + 
			"        h.vendor_id,\r\n" + 
			"        v.vendor_name,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.mrn_no,\r\n" + 
			"        d.po_no,\r\n" + 
			"        h.mrn_status\r\n" + 
			"    FROM\r\n" + 
			"        t_mrn_header h,\r\n" + 
			"        t_mrn_detail d,\r\n" + 
			"        m_vendor v\r\n" + 
			"    WHERE\r\n" + 
			"        h.mrn_id = d.mrn_id AND h.vendor_id = v.vendor_id AND h.mrn_date BETWEEN :fromDate AND :toDate\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.mrn_id\r\n" + 
			") t1\r\n" + 
			"LEFT JOIN(\r\n" + 
			"    SELECT\r\n" + 
			"        md.mrn_id,\r\n" + 
			"        SUM(\r\n" + 
			"            (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"        ) AS total_taxable_amt,\r\n" + 
			"        SUM(\r\n" + 
			"            (\r\n" + 
			"                (\r\n" + 
			"                    (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"                ) * pd.cgst\r\n" + 
			"            ) +(\r\n" + 
			"                (\r\n" + 
			"                    (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"                ) * pd.sgst\r\n" + 
			"            )\r\n" + 
			"        ) AS total_tax_amt,\r\n" + 
			"        SUM(\r\n" + 
			"            (\r\n" + 
			"                (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"            ) +(\r\n" + 
			"                (\r\n" + 
			"                    (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"                ) * pd.cgst\r\n" + 
			"            ) +(\r\n" + 
			"                (\r\n" + 
			"                    (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"                ) * pd.sgst\r\n" + 
			"            ) + pd.other_charges_after\r\n" + 
			"        ) AS grand_total,\r\n" + 
			"        SUM(pd.disc_value) AS total_disc_value,\r\n" + 
			"        SUM(pd.other_charges_befor) AS total_other_charges_before,\r\n" + 
			"        SUM(pd.other_charges_after) AS total_other_charges_after\r\n" + 
			"    FROM\r\n" + 
			"        t_mrn_header mh,\r\n" + 
			"        t_mrn_detail md,\r\n" + 
			"        po_detail pd\r\n" + 
			"    WHERE\r\n" + 
			"        md.del_status = 1 AND md.po_detail_id = pd.po_detail_id AND mh.mrn_date BETWEEN :fromDate AND :toDate AND mh.mrn_id = md.mrn_id\r\n" + 
			"    GROUP BY\r\n" + 
			"        mh.mrn_id\r\n" + 
			") t2\r\n" + 
			"ON\r\n" + 
			"    t1.mrn_id = t2.mrn_id"),nativeQuery=true)
	List<PurchaseHeaderDisplayForApp> getPurchaseHeaderByDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
