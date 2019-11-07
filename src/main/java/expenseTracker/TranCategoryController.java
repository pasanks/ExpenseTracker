package expenseTracker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class TranCategoryController {
    @Autowired
    TranCategoryRepository tranCat;
    @GetMapping("/category")
    public Map index(){
//        return transactionRespo.findAll();
        Map result = new HashMap();
        result.put("data", tranCat.findAll());
        result.put("status","success");

        return result;
    }

    @GetMapping("/category/{id}")
    public Map show(@PathVariable String id){
        int tranId = Integer.parseInt(id);
//        return transactionRespo.findOne(tranId);
        Map result = new HashMap();
        result.put("data", tranCat.findOne(tranId));
        result.put("status","success");

        return result;
    }

    @PostMapping("/category")
    public Map create(@RequestBody Map<String, String> body){

        String category_title = body.get("category_title");
        String category_type = body.get("category_type");
        tranCat.save(new TranCategory(category_title,category_type ));
        Map result = new HashMap();
        result.put("data","Category Successfully Added!");
        result.put("status","success");

        return result;
//        return v;
    }

}
