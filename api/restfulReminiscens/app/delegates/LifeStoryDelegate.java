package delegates;

import java.util.ArrayList;
import java.util.List;

import pojos.LifeStoryBean;
import utils.PlayDozerMapper;

public class LifeStoryDelegate {
    
    public static LifeStoryDelegate getInstance(){
        return new LifeStoryDelegate();
    }

    public List<LifeStoryBean> getAll() {
        List<models.LifeStory> modelLifeStorys = models.LifeStory.all();
        List<LifeStoryBean> pojosLifeStorys = new ArrayList<LifeStoryBean>();
        for (models.LifeStory lifeStory : modelLifeStorys) {
            LifeStoryBean lifeStoryBean = PlayDozerMapper.getInstance().map(lifeStory, LifeStoryBean.class);
            pojosLifeStorys.add(lifeStoryBean);
        }
        return pojosLifeStorys;
    }

    public LifeStoryBean getLifeStory(Long id) {
        models.LifeStory lifeStory = models.LifeStory.read(id);
        if (lifeStory != null) {
        	LifeStoryBean lifeStoryBean = PlayDozerMapper.getInstance().map(lifeStory, LifeStoryBean.class);
        	return lifeStoryBean;
        } else {
        	return null; 
        }
    }

    public void create(LifeStoryBean lifeStoryBean){
        models.LifeStory lifeStory = PlayDozerMapper.getInstance().map(lifeStoryBean, models.LifeStory.class);
        models.LifeStory.create(lifeStory);
        lifeStory = models.LifeStory.read(lifeStory.getLifeStoryId());
        PlayDozerMapper.getInstance().map(lifeStory,lifeStoryBean);
    }

    public void update(LifeStoryBean bean, Long id) {
        models.LifeStory lifeStory = PlayDozerMapper.getInstance().map(bean, models.LifeStory.class);
        lifeStory.update(id);
        lifeStory = models.LifeStory.read(lifeStory.getLifeStoryId());
        PlayDozerMapper.getInstance().map(lifeStory,bean);
    }

    public void deleteLifeStory(Long id) {
        models.LifeStory.delete(id);
    }
}
