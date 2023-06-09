package com.alpha.ThoseEngineers.controllers.jobs;

import com.alpha.ThoseEngineers.modules.jobs.data.File;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Domain;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Framework;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Language;
import com.alpha.ThoseEngineers.repositories.jobs.data.FileRepository;
import com.alpha.ThoseEngineers.repositories.jobs.data.JobRepository;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.DomainRepository;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.FrameworkRepository;
import com.alpha.ThoseEngineers.repositories.jobs.technicals.LanguageRepository;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class in {
    @Autowired
    public DomainRepository domainRepository;
    @Autowired
    public FileRepository fileRepository;
    @Autowired
    public FrameworkRepository frameworkRepository;
    @Autowired
    public LanguageRepository languageRepository;

    @PostMapping("/domain")
    public Domain input(@RequestBody Domain domain)
    {
        domainRepository.save(domain);
        return domain;
    }

    @PostMapping("/framework")
    public Framework input(@RequestBody Framework framework){
        frameworkRepository.save(framework);
        return framework;

    }

    @PostMapping("/language")
    public Language input(@RequestBody Language language){
        languageRepository.save(language);
        return language;
    }

    @PostMapping("/file")
    public File input(@RequestBody File file){
        fileRepository.save(file);
        return file;
    }
}
