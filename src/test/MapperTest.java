package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.User;
import bean.UserExample;

public class MapperTest
{
	private static final UserMapper mapper = null;

	@Test
	// 按主键查询
	public void Test1() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);
		// 按主键查询
		User user = mapper.selectByPrimaryKey(5);

		System.out.println(user.toString());

	}

	@Test
	// 按条件查询
	public void Test2() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);
		// 按条件查询
		UserExample example = new UserExample();
		// 将条件封装到 集合中
		example.createCriteria().andUSexEqualTo("1").andUUsernameLike("%王%");

		List<User> list = mapper.selectByExample(example);

		for (User user : list)
		{
			System.out.println(user);
		}
	}
	@Test
	// 插入
	public void Test3() throws IOException
	{
		String source = "sqlMapConfig.xml";
		// 读取配置文件
		InputStream in = Resources.getResourceAsStream(source);

		// 需要 sqlSeesionFactotyBuliber
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);

		// 生产一个sqlSession
		SqlSession session = ssf.openSession();

		// 操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		User user =new User();
		
		user.setuUsername("xiao");
		user.setuId(22);
		
		mapper.insertSelective(user);
		session.commit();

	}

}