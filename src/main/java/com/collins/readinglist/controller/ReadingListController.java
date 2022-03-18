package com.collins.readinglist.controller;

import com.collins.readinglist.model.Book;
import com.collins.readinglist.repository.ReadingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ReadingListController {

    private final ReadingListRepository repository;

    @RequestMapping(value = "/{reader}", method=RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {

        List<Book> readingList = repository.findByReader(reader);

        if (!isNull(readingList)) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method=RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        repository.save(book);
        return "redirect:/{reader}";
    }
}
