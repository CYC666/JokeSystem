package com.system.joke.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional      // 把@Transactional 注解放在类级别时，表示所有该类的公共方法都配置相同的事务属性信息
public interface JokeService extends JpaRepository<JokeModel, Integer> {


    // 获取段子详情
    public JokeModel getJokeModelById(int id);

    // 自定义语句-获取段子详情
    @Query(value = "select * from joke_list where id = :jokeId", nativeQuery = true)
    public JokeModel getJokeWithId(int jokeId);

    // 更新段子内容
    @Modifying      // 注解是通知jpa，这是一个update或者delete操作，在更新或者删除操作时，此注解必须加，否则会抛出异常
    @Query(value = "update joke_list set content = :jokeContent where id = :jokeId", nativeQuery = true)
    public void updateJokeWithIdAndContent(int jokeId, String jokeContent);

    // 增加一个段子
    @Modifying
    @Query(value = "insert into joke_list(id,content,creat_time) values (?1,?2,?3)", nativeQuery = true)
    public void addJokeWithIdAndContent(int jokeId, String jokeContent, String jokeTime);


}
