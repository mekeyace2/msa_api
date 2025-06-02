package site.msa;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface mapper {
	List<member_DTO> member_list();
}
