//
//  EventsTVC.swift
//  Feasta
//
//  Created by amota511 on 4/5/18.
//  Copyright © 2018 Aaron Motayne. All rights reserved.
//

import UIKit

class EventsTVC: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        self.tableView.register(EventCell.self, forCellReuseIdentifier: "eventCell")
        
        self.navigationController?.navigationBar.tintColor = .white
        
        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        let promoterAddButton = UIBarButtonItem(image: #imageLiteral(resourceName: "plusButton"), style: UIBarButtonItemStyle.plain, target: self, action: #selector(createPost))
         self.navigationItem.rightBarButtonItem = promoterAddButton
        
        self.navigationItem.title = "Events"
    }
    
    @objc func createPost() {
        
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 4
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "eventCell", for: indexPath) as! EventCell

        // User Photo
        cell.userImg.image = #imageLiteral(resourceName: "sgi-logo-sm")
        cell.userImg.contentMode = .scaleAspectFit
        cell.userImg.clipsToBounds = true
        
        cell.userImg.frame.origin = CGPoint(x: 6, y: 6)
        cell.userImg.frame.size = CGSize(width: 30, height: 30)
        
        cell.userImg.layer.cornerRadius = cell.userImg.frame.width / 2
        cell.userImg.layer.borderColor = UIColor.black.cgColor
        cell.userImg.layer.borderWidth = 1
        
        cell.addSubview(cell.userImg)
        
        // User Name
        cell.userName.text = "Student Government Inc."
        
        cell.userName.frame.origin = CGPoint(x: cell.userImg.frame.origin.x + cell.userImg.frame.width + 3, y: cell.userImg.frame.origin.y + 5)
        cell.userName.frame.size = CGSize(width: (cell.frame.width * 0.8) - (cell.userImg.frame.width + 3), height: cell.userImg.frame.height * 0.5)
        
        cell.userName.font = cell.userName.font.withSize(15)
        
        //cell.userName.backgroundColor = .green
        
        cell.addSubview(cell.userName)
        
        // Location
        cell.eventLocation.text = "DAC 401"
        
        cell.eventLocation.frame.origin = CGPoint(x: cell.userName.frame.origin.x, y: cell.userName.frame.maxY + 5)
        cell.eventLocation.frame.size = CGSize(width: cell.userName.frame.width, height: cell.userName.frame.height * 0.75)
        
        cell.eventLocation.font = cell.eventLocation.font.withSize(10)
        
        cell.addSubview(cell.eventLocation)
        
        // Time
        cell.timeOfEvent.text = "@" + "12:05 PM"
        
        cell.timeOfEvent.frame.origin = CGPoint(x: cell.userName.frame.maxX + 3, y: cell.userName.frame.origin.y)
        cell.timeOfEvent.frame.size = CGSize(width: cell.frame.width - (cell.userName.frame.maxX + 3), height: cell.userName.frame.height)
        
        cell.timeOfEvent.font = cell.timeOfEvent.font.withSize(15)
        cell.timeOfEvent.adjustsFontSizeToFitWidth = true
        
        //cell.timeOfEvent.backgroundColor = .green
        
        cell.addSubview(cell.timeOfEvent)
        
        //Event Photo
        cell.eventImg.image = #imageLiteral(resourceName: "SGI Food Event")
        cell.eventImg.contentMode = .scaleAspectFit
        cell.eventImg.clipsToBounds = true
        
        cell.eventImg.frame.origin = CGPoint(x: cell.userImg.frame.origin.x, y: cell.eventLocation.frame.maxY + 3)
        cell.eventImg.frame.size = CGSize(width: cell.frame.width - (cell.userImg.frame.origin.x * 2), height: cell.frame.height * 0.78)
        
        /*
        cell.eventImg.layer.borderColor = UIColor.black.cgColor
        cell.eventImg.layer.borderWidth = 1
        */
        //cell.eventImg.backgroundColor = .blue
 
        cell.addSubview(cell.eventImg)
        
        //Like Button
        cell.likeButton.image = #imageLiteral(resourceName: "like")
        cell.likeButton.contentMode = .scaleAspectFit
        cell.likeButton.clipsToBounds = true
        
        cell.likeButton.frame.origin = CGPoint(x: cell.userImg.frame.origin.x, y: cell.eventImg.frame.maxY + 5)
        cell.likeButton.frame.size = CGSize(width: cell.userImg.frame.size.width, height: cell.userImg.frame.size.height)

        
        cell.addSubview(cell.likeButton)
        
        //Like Count
        cell.likeCount.text = "110" + " Likes"
        
        cell.likeCount.frame.origin = CGPoint(x: cell.likeButton.frame.maxX + 2, y: cell.likeButton.frame.origin.y + (cell.likeButton.frame.height * 0.5))
        cell.likeCount.frame.size = CGSize(width: cell.frame.size.width * 0.12, height: cell.likeButton.frame.size.height * 0.33)
        
        cell.likeCount.font = cell.likeCount.font.withSize(10)
        cell.likeCount.adjustsFontSizeToFitWidth = true
        
        //cell.likeCount.backgroundColor = .blue
        
        cell.addSubview(cell.likeCount)
        
        //Comment Button
        cell.commentButton.image = #imageLiteral(resourceName: "comment")
        cell.commentButton.contentMode = .scaleAspectFit
        cell.commentButton.clipsToBounds = true
        
        cell.commentButton.frame.origin = CGPoint(x: cell.frame.maxX - (cell.likeButton.frame.width + 15), y: cell.likeButton.frame.origin.y)
        cell.commentButton.frame.size = CGSize(width: cell.likeButton.frame.size.width, height: cell.likeButton.frame.size.height)
        
        
        cell.addSubview(cell.commentButton)
        
        return cell
    }
 

    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return self.view.frame.height * 0.6
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
