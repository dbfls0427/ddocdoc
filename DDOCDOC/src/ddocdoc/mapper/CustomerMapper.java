package ddocdoc.mapper;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.LoginVO;

public interface CustomerMapper {
	int insertCustomer(CustomerVO customer);
	
	CustomerVO loginCustomer(LoginVO login);
	

}
