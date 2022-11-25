package api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import api.models.Support;
import api.models.UserData;

import java.util.List;

@Data
public class UserListResponse{

	@JsonProperty("per_page")
	private int perPage;

	@JsonProperty("total_pages")
	private int totalPages;

	@JsonProperty("data")
	private List<UserData> userData;

	private int total;
	private int page;
	private Support support;
}