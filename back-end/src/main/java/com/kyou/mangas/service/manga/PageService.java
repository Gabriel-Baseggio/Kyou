package com.kyou.mangas.service.manga;

import com.kyou.mangas.model.manga.Page;
import com.kyou.mangas.repository.manga.PageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PageService {

    private final PageRepository pageRepository;

    public List<Page> getPages() {
        return pageRepository.findAll();
    }

    public Page getPageById(Integer id) {
        Optional<Page> optional = pageRepository.findById(id);

        if (optional.isEmpty())
            throw new RuntimeException("Página não encontrada");

        return optional.get();
    }

    public Page getPageByNumber(Integer page) {
        return pageRepository.findByNumber(page);
    }

    public Page createPage(Page category) {
        return pageRepository.save(category);
    }

    public Page updatePage(Page updatedPage) {
        validatePage(updatedPage.getId());
        return pageRepository.save(updatedPage);
    }

    public String deletePage(Integer id) {
        validatePage(id);

        pageRepository.deleteById(id);

        if (pageRepository.existsById(id))
            throw new RuntimeException("Não foi possível deletar a página de id: " + id);

        return "Página de id " + id + " deletada";
    }

    private void validatePage(Integer id) {
        if (!(pageRepository.existsById(id)))
            throw new RuntimeException("Página não encontrada");
    }


}
