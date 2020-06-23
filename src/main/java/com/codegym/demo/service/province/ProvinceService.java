package com.codegym.demo.service.province;

import com.codegym.demo.model.Province;
import com.codegym.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService{

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        Optional<Province> optionalProvince = provinceRepository.findById(id);
        return optionalProvince.orElseThrow(() ->  new ProvinceNotFoundException("Couldn't find Customer with id: " + id));
    }

    @Override
    public void save(Province model) {
        provinceRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
