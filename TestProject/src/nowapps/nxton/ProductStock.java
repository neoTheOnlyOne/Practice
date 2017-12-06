package nowapps.nxton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductStock {

	private Long id;
	private Integer quantity;

	List<ProductStock> productStockList;

	public ProductStock() {
		productStockList = new ArrayList<>();

		productStockList.add(new ProductStock(1L, 1));
		productStockList.add(new ProductStock(2L, 1));
		productStockList.add(new ProductStock(3L, 1));
		productStockList.add(new ProductStock(1L, 1));
		productStockList.add(new ProductStock(4L, 1));
		productStockList.add(new ProductStock(5L, 1));
		productStockList.add(new ProductStock(2L, 1));

	}

	public ProductStock(Long id, Integer qty) {
		this.id = id;
		this.quantity = qty;
	}

	void mergeProducts2() {
		Map<Long, Integer> pMap = new LinkedHashMap<Long, Integer>();
		for (ProductStock ps : productStockList) {
			if (pMap.containsKey(ps.getId())) {
				int qty = pMap.get(ps.getId());
				qty += ps.getQuantity();
				pMap.put(ps.getId(), qty);
			} else {
				pMap.put(ps.getId(), ps.getQuantity());
			}
		}

		System.out.println("traditional way: ");
		for (Map.Entry<Long, Integer> entry : pMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	void mergeProducts() {
		//One note though: Collectors.counting() will count the products not aggregate the quantities. Try with initial quantities other than 1
		Map<Long, Long> productMap = productStockList.stream()
				.collect(Collectors.groupingBy(ProductStock::getId, Collectors.counting()));

		System.out.println("productStock");
		for (Map.Entry<Long, Long> entry : productMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}


		productStockList = new ArrayList<ProductStock>();

		for (Map.Entry<Long, Long> entry : productMap.entrySet()) {
			productStockList.add(new ProductStock(entry.getKey(), (int) entry.getValue().intValue()));
		}
		
	}

	void mergeProducts3() {
		productStockList = new ArrayList<>(
				productStockList.stream().collect(Collectors.toMap(p -> p.id, p -> p, (p, o) -> {
					p.quantity += o.quantity;
					return p;
				})).values());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductStock ps = new ProductStock();
		ps.mergeProducts();
		ps.mergeProducts2();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
