package delegates;

import pojos.TimelineBean;
import utils.PlayDozerMapper;

public class TimelineDelegate {
    
    public static TimelineDelegate getInstance(){
        return new TimelineDelegate();
    }

    public TimelineBean getTimeline(Long id) {
        models.Timeline timeline = models.Timeline.readByPerson(id);
        if (timeline != null) {
        	TimelineBean timelineBean = PlayDozerMapper.getInstance().map(timeline, TimelineBean.class);
        	return timelineBean;
        } else {
        	return null; 
        }
    }
   
    public TimelineBean getTimelineWithLimits(Long id, Long from, Long to) {
        models.Timeline timeline = models.Timeline.readByPersonWithLimits(id, from, to);
        if (timeline != null) {
        	TimelineBean timelineBean = PlayDozerMapper.getInstance().map(timeline, TimelineBean.class);
        	return timelineBean;
        } else {
        	return null; 
        }
    }

    public void synchronize(TimelineBean bean) {
        models.Timeline timeline = PlayDozerMapper.getInstance().map(bean, models.Timeline.class);
        models.Timeline.synchronize(timeline);
    }

}
