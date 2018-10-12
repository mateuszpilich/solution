package dao;

import domain.Request;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DaoRepositoryImplTest {
    private DaoRepositoryImpl daoRepository;
    private Connection connection;

    @Before
    public void init() {
        connection = Mockito.mock(Connection.class);
        this.daoRepository = Mockito.spy(new DaoRepositoryImpl(connection));
    }

    @Test
    public void testShouldGiveTotalRequestsNumber_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(14)).when(resultSet).getLong(Mockito.anyInt());
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumber();

        // then
        assertEquals(Long.valueOf(14), result);
    }

    @Test
    public void testShouldGiveTotalRequestsNumber_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(0)).when(resultSet).getLong(Mockito.anyInt());
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumber();

        // then
        assertEquals(Long.valueOf(0), result);
    }

    @Test
    public void testShouldGiveTotalRequestsNumber_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doThrow(new SQLException()).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumber();

        // then
        assertEquals(null, result);
    }

    @Test
    public void testShouldGiveTotalRequestsNumberByClientId_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(4)).when(resultSet).getLong(Mockito.anyInt());
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " COUNT(id) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        Long result = daoRepository.totalRequestsNumberByClientId(1L);

        // then
        assertEquals(Long.valueOf(4), result);
    }

    @Test
    public void testShouldGiveTotalRequestsNumberByClientId_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(0)).when(resultSet).getLong(Mockito.anyInt());
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " COUNT(id) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        Long result = daoRepository.totalRequestsNumberByClientId(1L);

        // then
        assertEquals(Long.valueOf(0), result);
    }

    @Test
    public void testShouldGiveTotalRequestsNumberByClientId_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doThrow(new SQLException()).when(connection).prepareStatement("SELECT COUNT(id)"
                + " FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        Long result =
                daoRepository.totalRequestsNumberByClientId(Long.valueOf(1L));

        // then
        assertEquals(null, result);
    }

    @Test
    public void testShouldGiveTotalRequestsPrice_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(120.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPrice();

        // then
        assertEquals(BigDecimal.valueOf(120.0).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void testShouldGiveTotalRequestsPrice_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPrice();

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void testShouldGiveTotalRequestsPrice_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doThrow(new SQLException()).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPrice();

        // then
        assertEquals(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_CEILING),
                result);
    }

    @Test
    public void testShouldGiveTotalRequestsPriceByClientId_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(20.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " SUM(price) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        BigDecimal result = daoRepository.totalRequestsPriceByClientId(1L);

        // then
        assertEquals(BigDecimal.valueOf(20.0).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void testShouldGiveTotalRequestsPriceByClientId_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " SUM(price) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        BigDecimal result = daoRepository.totalRequestsPriceByClientId(1L);

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void testShouldGiveTotalRequestsPriceByClientId_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doThrow(new SQLException()).when(connection).prepareStatement("SELECT SUM"
                + "(price) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result =
                daoRepository.totalRequestsPriceByClientId(Long.valueOf(1L));

        // then
        assertEquals(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_CEILING),
                result);
    }


    @Test
    public void testShouldGiveAverageValueOfRequest_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(13.33).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequest();

        // then
        assertEquals(BigDecimal.valueOf(13.33).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void testShouldGiveAverageValueOfRequest_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequest();

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void testShouldGiveAverageValueOfRequest_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doThrow(new SQLException()).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequest();

        // then
        assertEquals(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_CEILING),
                result);
    }

    @Test
    public void testShouldGiveAverageValueOfRequestToClientById_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(11.67).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " AVG(price) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        BigDecimal result = daoRepository.averageValueOfRequestToClientById(1L);

        // then
        assertEquals(BigDecimal.valueOf(11.67).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void testShouldGiveAverageValueOfRequestToClientById_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " AVG(price) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        BigDecimal result = daoRepository.averageValueOfRequestToClientById(1L);

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void testShouldGiveAverageValueOfRequestToClientById_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doThrow(new SQLException()).when(connection).prepareStatement("SELECT AVG"
                + "(price) FROM request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        BigDecimal result =
                daoRepository.averageValueOfRequestToClientById(Long.valueOf(1L));

        // then
        assertEquals(BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_CEILING),
                result);
    }

    @Test
    public void testShouldGiveListOfAllRequests_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn("").when(resultSet).getString("client_id");

        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        List<Request> result = daoRepository.listOfAllRequests();

        // then
        assertEquals(1, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequests_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(true).doReturn(true)
                .doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn("").when(resultSet).getString("client_id");
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        Mockito.doReturn(statement).when(connection).createStatement();

        // when
        List<Request> result = daoRepository.listOfAllRequests();

        // then
        assertEquals(4, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequests_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doThrow(new SQLException()).when(connection).createStatement();

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        List<Request> result = daoRepository.listOfAllRequests();

        // then
        assertEquals(0, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequestsToClientById_1() throws SQLException {
        // given
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " * FROM request WHERE client_id = ?");
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        Mockito.doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn("").when(resultSet).getString("client_id");

        // when
        List<Request> result = daoRepository.listOfAllRequestsToClientById(13L);

        // then
        assertEquals(1, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequestsToClientById_2() throws SQLException {
        // given
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(statement).when(connection).prepareStatement("SELECT"
                + " * FROM request WHERE client_id = ?");
        Mockito.doReturn(resultSet).when(statement).executeQuery();
        Mockito.doReturn(true).doReturn(true).doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn("").when(resultSet).getString("client_id");

        // when
        List<Request> result = daoRepository.listOfAllRequestsToClientById(13L);

        // then
        assertEquals(3, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequestsToClientById_3() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        Mockito.doThrow(new SQLException()).when(connection).prepareStatement("SELECT * FROM "
                + "request WHERE client_id = ?");

        // when
        Mockito.doReturn(resultSet).when(statement).executeQuery(Mockito.anyString());
        List<Request> result =
                daoRepository.listOfAllRequestsToClientById(Long.valueOf(1L));

        // then
        assertEquals(0, result.size());
    }

    @Test
    public void testShouldGiveExecuteQuery_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Statement statement = Mockito.mock(Statement.class);
        Mockito.doReturn(statement).when(connection).createStatement();
        Mockito.doReturn(resultSet).when(statement).executeQuery("SELECT " +
                "* FROM REQUEST");

        // when
        ResultSet result = daoRepository.executeQuery("SELECT * FROM request");

        // then
        assertEquals(null, result);
    }

    @Test
    public void testShouldGivePrepareRequest_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(1L).when(resultSet).getLong("id");
        Mockito.doReturn("c1L").when(resultSet).getString("client_id");
        Mockito.doReturn(1L).when(resultSet).getLong("request_id");
        Mockito.doReturn("apple").when(resultSet).getString("name");
        Mockito.doReturn(1).when(resultSet).getInt("quantity");
        Mockito.doReturn(BigDecimal.ONE).when(resultSet).getBigDecimal("price");

        // when
        Request result = daoRepository.prepareRequest(resultSet);

        // then
        assertEquals(new Request(1L, "c1L", 1L,
                "apple", 1, BigDecimal.ONE), result);

    }
}
