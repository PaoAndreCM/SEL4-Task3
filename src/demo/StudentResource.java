package demo;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Path("/students")
public class StudentResource {
	private static Map<Integer, Student> map;
	private static AtomicInteger counter = new AtomicInteger();

	static {
		map = new ConcurrentHashMap<>();
		map.put(1, new Student("1", "Paola", "Carreno"));
	    map.put(2, new Student("2", "Sahar", "Behravesh"));
		map.put(3, new Student("3", "Yadi", "Pemberton"));
		counter.set(3);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllStudentsAsText() {
		StringBuilder stringBuilder = new StringBuilder();
		map.values().stream()
				.sorted((m1, m2) -> m1.getLastName().compareTo(m2.getLastName()))
				.forEach(m -> stringBuilder.append(m.toString() + "\n"));
		return stringBuilder.toString();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getStudentAsText(@PathParam("id") int id) {
		Student student = map.get(id);
		if (student == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(student.toString()).build();
	}

/* 	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAllMessagesAsHtml() {
		StringBuilder stringBuilder = new StringBuilder("<html><head><meta charset=\"UTF-8\"></head><body><table border='1'>");
		map.values().stream()
				.sorted((m1, m2) -> -m1.getTimestamp().compareTo(m2.getTimestamp()))
				.forEach(m -> stringBuilder.append("<tr><td>")
						.append(m.getId())
						.append("</td><td>")
						.append(m.getText())
						.append("</td><td>")
						.append(m.getTimestamp())
						.append("</td></tr>")
				);
		stringBuilder.append("</table></body></html>");
		return stringBuilder.toString();
	} */

	/* @GET
	@Path("{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response getMessageAsHtml(@PathParam("id") int id) {
		Student message = map.get(id);
		if (message == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
		StringBuilder stringBuilder = new StringBuilder("<html><head><meta charset=\"UTF-8\"></head><body>");
		stringBuilder
				.append(message.getId())
				.append("<br>")
				.append(message.getText())
				.append("<br>")
				.append(message.getTimestamp())
				.append("</body></html>");
		return Response.ok(stringBuilder.toString()).build();
	} */

/* 	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudentsAsJson() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Student> list = map.values().stream()
				.sorted((m1, m2) -> m1.getLastName().compareTo(m2.getLastName()))
				.collect(Collectors.toList());
		return list;
	} */

	/* @GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessageAsJson(@PathParam("id") int id) {
		Student message = map.get(id);
		if (message == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(message).build();
	} */

	/* @GET
	@Path("limited")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllMessagesAsJsonLimited(@QueryParam("n") @DefaultValue("3") int n) {
		n = n <= 0 ? 3 : n;
		StringBuilder stringBuilder = new StringBuilder();
		List<Student> list = map.values().stream()
				.sorted((m1, m2) -> -m1.getTimestamp().compareTo(m2.getTimestamp()))
				.limit(n)
				.collect(Collectors.toList());
		return list;
	} */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newStudent(@Context UriInfo uriInfo, Student student) {
		int id = counter.incrementAndGet();
		String idString = String.valueOf(id);
		student.setId(idString);
		map.put(id, student);
		URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
		return Response.created(location).build();
	}

	/* @PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMessage(@PathParam("id") int id, Student message) {
		if (map.get(id) == null) {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		} else {
			message.setId(id);
			message.setTimestamp(Instant.now());
			map.put(id, message);
			return Response.noContent().status(Response.Status.OK).build();
		}
	} */

	/* @DELETE
	@Path("{id}")
	public Response deleteMessage(@PathParam("id") int id) {
		if (map.get(id) != null) {
			map.remove(id);
			return Response.noContent().status(Response.Status.OK).build();
		} else {
			return Response.noContent().status(Response.Status.NOT_FOUND).build();
		}
	} */

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response newStudentFromForm(@Context UriInfo uriInfo, @FormParam("fName") String firstName, 
										@FormParam("lName") String lastName) {
		int id = counter.incrementAndGet();
		String idString = String.valueOf(id);
		Student student = new Student(idString, firstName, lastName);
		map.put(id, student);
		URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
		return Response.created(location).status(Response.Status.MOVED_PERMANENTLY).build();
	} 

}
