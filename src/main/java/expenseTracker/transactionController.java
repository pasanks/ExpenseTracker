package expenseTracker;

//public class transactionController {
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class transactionController {

    @Autowired
    transactionRespository transactionRespo;

    @GetMapping("/transaction")
    public Map index(){
//        return transactionRespo.findAll();
        Map result = new HashMap();
        result.put("data", transactionRespo.findAll());
        result.put("status","success");

        return result;
    }


    @GetMapping("/transactionTopTen")
    public Map selectTopTen(){
//        return transactionRespo.findAll();
        Map result = new HashMap();
        result.put("data", transactionRespo.selectTopTen());
        result.put("status","success");

        return result;
    }

    @GetMapping("/transaction/{id}")
    public Map show(@PathVariable String id){
        int tranId = Integer.parseInt(id);
//        return transactionRespo.findOne(tranId);
        Map result = new HashMap();
        result.put("data", transactionRespo.findOne(tranId));
        result.put("status","success");

        return result;
    }

//    @PostMapping("/transaction/search")
//    public List<transaction> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("text");
//        return transactionRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }

    @PostMapping("/transaction")
    public Map create(@RequestBody Map<String, String> body){
        String v = "fdsasdc";
        String category = body.get("category");
        double amount = Double.parseDouble(body.get("amount"));
        String remarks = body.get("remarks");
        String tran_date = body.get("tran_date");
         transactionRespo.save(new transaction(category, amount, remarks, tran_date));
        Map result = new HashMap();
        result.put("data","Transaction Successfully Added!");
        result.put("status","success");

        return result;
//        return v;
    }

    @PutMapping("/transaction/{id}")
    public Map update(@PathVariable String id, @RequestBody Map<String, String> body){
        int tranId = Integer.parseInt(id);
        // getting blog
        transaction tran = transactionRespo.findOne(tranId);
        tran.setCategory(body.get("category"));
        tran.setAmount(Double.parseDouble(body.get("amount")));
        tran.setRemarks(body.get("remarks"));
        tran.setTranDate(body.get("tran_date"));


        transactionRespo.save(tran);
//        return transactionRespo.save(tran);
        Map result = new HashMap();
        result.put("data","Transaction Successfully Updated!");
        result.put("status","success");

        return result;
    }

    @DeleteMapping("transaction/{id}")
    public Map delete(@PathVariable String id){
        int tranId = Integer.parseInt(id);
        transactionRespo.delete(tranId);
//        return true;
        Map result = new HashMap();
        result.put("data","Transaction Successfully Updated!");
        result.put("status","success");

        return result;
    }

    @GetMapping("/testfun")
    public Map testFun(){
           transaction tran = new transaction();
        Map result = new HashMap();
        result.put("data",tran.testFunc());
        result.put("status","success");

        return result;

    }
}