package com.example.demo.logs;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DurationRepositoryImpl implements DurationRepositoryCustom {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Duration> getDuration() {
//        Query query = em.createNamedQuery("Update l1 SET l1.duration = DATEDIFF(SECOND,l1.starttime,l2.starttime)from dbo.logs l1 join dbo.logs l2 on l1.INSTANCE_ID = l2.instance_id where l2.status in ('Finished', 'Cancelled') and l1.status='Started'",UniqLogs.class);
       Query query1 = em.createNativeQuery("select l1.INSTANCE_ID, l1.starttime, l2.status, l1.JOB_NAME, l1.job_id, l1.startdate, l1.dated, l1.event_id, l1.duration from logs l1 join logs l2 on l1.INSTANCE_ID=l2.INSTANCE_ID where l1.status='Started' \n" +
                "and l2.status in ('Finished', 'Cancelled')",Duration.class);
//        System.out.println(query.getResultList());
        return query1.getResultList();
    }
}
