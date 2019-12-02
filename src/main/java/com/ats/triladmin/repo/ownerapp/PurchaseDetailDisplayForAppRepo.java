package com.ats.triladmin.repo.ownerapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ownerapp.PurchaseDetailDisplayForApp;

public interface PurchaseDetailDisplayForAppRepo extends JpaRepository<PurchaseDetailDisplayForApp, Integer>{
	
	
	@Query(value=("SELECT\r\n" + 
			"    md.mrn_detail_id,\r\n" + 
			"    md.mrn_id,\r\n" + 
			"    md.po_detail_id,\r\n" + 
			"    md.item_id,\r\n" + 
			"    i.item_desc,\r\n" + 
			"    i.item_uom,\r\n" + 
			"    md.mrn_qty,\r\n" + 
			"    pd.item_rate,\r\n" + 
			"    pd.cgst,\r\n" + 
			"    pd.sgst,\r\n" + 
			"    pd.igst,\r\n" + 
			"    pd.disc_value,\r\n" + 
			"    (\r\n" + 
			"        (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"    ) AS taxable_amt,\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"            (\r\n" + 
			"                (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"            ) * pd.cgst\r\n" + 
			"        ) +(\r\n" + 
			"            (\r\n" + 
			"                (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"            ) * pd.sgst\r\n" + 
			"        )\r\n" + 
			"    ) AS tax_amt,\r\n" + 
			"    (\r\n" + 
			"        (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"    ) +(\r\n" + 
			"        (\r\n" + 
			"            (\r\n" + 
			"                (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"            ) * pd.cgst\r\n" + 
			"        ) +(\r\n" + 
			"            (\r\n" + 
			"                (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"            ) * pd.sgst\r\n" + 
			"        )\r\n" + 
			"    ) + pd.other_charges_after AS grand_total,\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"            (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"        ) * pd.cgst\r\n" + 
			"    ) AS cgst_amt,\r\n" + 
			"    (\r\n" + 
			"        (\r\n" + 
			"            (pd.item_rate * md.mrn_qty) - pd.disc_value + pd.other_charges_befor\r\n" + 
			"        ) * pd.sgst\r\n" + 
			"    ) AS sgst_amt,\r\n" + 
			"    pd.other_charges_befor,\r\n" + 
			"    pd.other_charges_after\r\n" + 
			"FROM\r\n" + 
			"    t_mrn_detail md,\r\n" + 
			"    t_mrn_header mh,\r\n" + 
			"    m_item i,\r\n" + 
			"    po_detail pd\r\n" + 
			"WHERE\r\n" + 
			"    mh.mrn_id = md.mrn_id AND md.item_id = i.item_id AND md.po_detail_id = pd.po_detail_id AND md.item_id = pd.item_id AND mh.mrn_date BETWEEN :fromDate AND :toDate AND mh.del_status = 1 AND md.del_status = 1"),nativeQuery=true)
	List<PurchaseDetailDisplayForApp> getPurchaseDetailByDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	
	
	//taxable_amt=(po_rate*mrn_qty)-disc_value+other_charges_before

	//tax_amt=(taxable_amt*cgst_per) + (taxable_amt*sgst_per)
	
	//grand_total=taxable_amt+tax+other_charges_after
	
}

